
public class SsafyStack<E> implements IStack<E> {
	private Node<E> top;

	public SsafyStack(Node<E> top) {
		super();
		this.top = top;
	}

	@Override
	public void push(E data) {
		top = new Node<E>(data, top);
		
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("empty");
			return null;
		}
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("empty");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		for (Node temp = top; temp != null; temp = temp.link) {
			++cnt;
		}
		return cnt;
	}
}
