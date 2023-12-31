package atividade04;

import java.util.ArrayList;

public class BST implements BST_IF {
    protected Integer data;
    protected BST left;
    protected BST right;
    protected BST parent;

    @Override
    public void insert(int element) {
        if (this.data == null) {
            this.data = element;

            this.left = new BST();
            this.left.parent = this;

            this.right = new BST();
            this.right.parent = this;

            return;
        }

        if (element < this.data) {
            this.left.insert(element);
        }

        if (element > this.data) {
            this.right.insert(element);
        }

    }

    @Override
    public Integer search(int element) throws Exception {
        if (this.data == null) {
            throw new Exception("O elemento não existe na BST!");
        }

        if (this.data.equals(element))
            return element;

        if (element < this.data)
            return this.left.search(element);

        if (element > this.data)
            return this.right.search(element);

        throw new Exception("O elemento não existe na BST!");
    }

    @Override
    public int[] preOrder() {
        ArrayList<Integer> elements = new ArrayList<Integer>();

        preOrder(this, elements);

        int[] elementsInt = arrayListToIntArray(elements);
        return elementsInt;
    }

    private static void preOrder(BST bst, ArrayList<Integer> elements) {
        if (bst.data != null) {
            elements.add(bst.data);
            preOrder(bst.left, elements);
            preOrder(bst.right, elements);
        }
    }

    @Override
    public int[] order() {
        ArrayList<Integer> elements = new ArrayList<Integer>();

        order(this, elements);

        int[] elementsInt = arrayListToIntArray(elements);
        return elementsInt;
    }

    private static void order(BST bst, ArrayList<Integer> elements) {
        if (bst.data != null) {
            order(bst.left, elements);
            elements.add(bst.data);
            order(bst.right, elements);
        }
    }

    @Override
    public int[] postOrder() {
        ArrayList<Integer> elements = new ArrayList<Integer>();

        postOrder(this, elements);

        int[] elementsInt = arrayListToIntArray(elements);
        return elementsInt;
    }

    private static void postOrder(BST bst, ArrayList<Integer> elements) {
        if (bst.data != null) {
            postOrder(bst.left, elements);
            postOrder(bst.right, elements);
            elements.add(bst.data);
        }
    }

    @Override
    public boolean isComplete() {
        return isComplete(this, 0, getHeight(this));
    }

    private static boolean isComplete(BST bst, int i, int height) {
        if (bst == null)
            return true;

        if (i >= height)
            return false;

        return (isComplete(bst.left, 2 * i + 1, height)
                && isComplete(bst.right, 2 * i + 2, height));
    }

    private static int getHeight(BST bst) {
        if (bst == null)
            return (0);
        return (1 + getHeight(bst.left) + getHeight(bst.right));
    }

    private static int[] arrayListToIntArray(ArrayList<Integer> arrayList) {
        int[] elementsInt = new int[arrayList.size()];
        for (int i = 0; i < elementsInt.length; i++) {
            elementsInt[i] = arrayList.get(i);
        }

        return elementsInt;
    }

}
