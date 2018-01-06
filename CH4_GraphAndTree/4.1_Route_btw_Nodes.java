//An iterative implementation of breadth-first search
enum State { Unvisited, Visited, Visiting;}

boolean search(Graph g, Node start, Node end) {
    if (start == end) {
        return true;
    }
    // operates as Queue
    LinkedList<Node> queue = new LinkedList<Node>();

    //set all nodes state as Unvisited
    for (Node node : g.getNodes()) {
        node.state = State.Unvisited;
    }

    start.state = Visiting;
    //enqueue the start node
    queue.add(start);
    Node node;
    while (!queue.isEmpty()) {
        node = q.removeFirst(); //dequeue
        if (node != null) {
            for (Node v : node.getAdjacent()) {
                if (v.state == State.Unvisited) {
                    if (v == end) {
                        return true;
                    } else {
                        v.state = State.Visiting;
                        q.add(v);
                    }

                }
            }
            node.state = State.Visited;
        }


    }
    return false;

}
