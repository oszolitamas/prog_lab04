package lab_04;

public class Test {
	static public void main(String[] args) {
		PQueue<String> queue = new PQueue<>();
        queue.push("alma");
        queue.push("korte");
        queue.push("barack");
        System.out.println("Meret: " + queue.size());
        System.out.println("Top: " + queue.top()); 
        System.out.println("Meret a top után: " + queue.size());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Top: " + queue.top());
        System.out.println("Meret a pop utan: " + queue.size());
        queue.clear();
        System.out.println("Meret clear utan: " + queue.size());
        try {
            queue.pop();
        } catch (EmptyQueueException e) {
            System.out.println(e.getMessage());
        }
        try {
            queue.top();
        } catch (EmptyQueueException e) {
            System.out.println(e.getMessage());
        }
        //10. feladat
        PQueue<Integer> s = new PQueue<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        for (Integer i : s) {
        System.out.println(i);
        }
	}
}
