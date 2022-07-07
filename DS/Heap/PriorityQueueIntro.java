import java.util.PriorityQueue;

class PriorityQueueIntro {
	public static void main(String[] args) {
		
		/* Inside priority queue elements are stored in random order but when we try fetch them, they are fetched based on priority
			We can define priority using comparator, but if we have not defined any comparator then it will take some default priority
			Like for e.g: Strings priority will be in chronological order, for e.g: if strings are: ["HELLO", "ABC", "YO"], then "ABC will have priority 1, "HELLO*:2, and "YO":3 
			Similarly for integers: priorties are on basis of ascending order, if array is: [3, 5, 1]: Priority 1: 1, Priority 2: 3 & Priority 3: 5
		*/
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("HELLO");
		pq.add("YES");
		pq.add("CODE");
		pq.add("BRO");
		System.out.println(pq);

		System.out.println(pq.remove());
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		System.out.println(pq.remove());

	}
}