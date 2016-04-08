public class UnionFind {
	private int[] parent;	// link to parent
	private int[] size;	// size of components for roots
	private int count;	// number of components

	public UnionFind(int N) {
		count = N;
		parent = new int[N];
		for(int i =0; i < N; i++)
			parent[i] = i;
		size = new int[N];
		for(int i = 0; i < N; i++) 
			size[i] = i;
	}

	public int getCount() {
		return count;
	}

	// determine if the roots of p and q are equal
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	// find the root value
	private int find(int p) {
		while(p != parent[p])
			p = parent[p];
		return p;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		// path compression so that each parent is the root
		while (parent[p] != pRoot) {
			int pParent = parent[p];	// holds index of next node to process
			parent[p] = pRoot;
			p = pParent;
		}
		while (parent[q] != qRoot) {
			int qParent = parent[q];	// holds index of next node to process
			parent[q] = qRoot;
			q = qParent;
		}
		if (pRoot == qRoot)
			return;

		// choose the root of the larger component to be the root of both components
		if (size[pRoot] < size[qRoot]) {
			parent[pRoot] = qRoot;
			size[qRoot] += size[pRoot];
		}else {
			parent[qRoot] = pRoot;
			size[pRoot] += size[qRoot];
		}
		count--;
	}

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int numConnections = file.nextInt();
		UnionFind network = new UnionFind(numConnections);
		while(file.hasNext()) {
			int p = file.nextInt();
			int q = file.nextInt();
			if (!network.isConnected(p, q)) {
				network.union(p, q);
				System.out.println(p + " " q);
			}
		}
		System.out.println(network.getCount() + " components");
	}
}

}
			
