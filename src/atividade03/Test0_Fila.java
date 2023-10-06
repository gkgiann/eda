package atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_Fila {

	static Fila_IF f;

	@Before // Instanciando a Fila antes de cada teste
	public void instanciaFila() throws Exception {
		f = new FilaComPilhas();
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertTrue(f.isEmpty());
		f.enqueue(Integer.MAX_VALUE);
		assertFalse(f.isEmpty());
	}

	@Test
	public void testEnqueueAndDequeue() throws Exception {
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(3);

		assertEquals(1, f.dequeue());
		assertEquals(2, f.dequeue());
		assertEquals(3, f.dequeue());

		assertTrue(f.isEmpty());
	}

	@Test
	public void testHead() throws Exception {
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(7);
		assertEquals(1, f.head());
		f.dequeue();
		assertEquals(2, f.head());

		f.enqueue(90);
		assertEquals(2, f.head());

		f.dequeue();
		f.dequeue();
		assertEquals(90, f.head());

	}

	@Test(expected = Exception.class)
	public void testEnqueue() throws Exception {
		for (int i = 1; i <= 11; i++) {
			f.enqueue(i);
		}
	}

	@Test(expected = Exception.class)
	public void testUnderFlow() throws Exception {
		f.dequeue();
	}

	@Test(expected = Exception.class)
	public void testHeadException() throws Exception {
		f.head();
	}

}