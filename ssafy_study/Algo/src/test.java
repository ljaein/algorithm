import java.util.LinkedList;

public class test {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		int a = list.get(1);
		int b = list.get(2);
		list.remove(1);
		list.remove(1);
		list.add(1,a+b);
		System.out.println(list.toString());
	}

}
