package Practice_Questions.pq;

public class MoviemanagementUsingDoublyLL {
    class Node {
        String movieName;
        Node prev;
        Node next;

        public Node(String movieName) {
            this.movieName = movieName;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;

    public MoviemanagementUsingDoublyLL() {
        this.head = null;
    }

    public void addMovie(String movieName) {
        Node newNode = new Node(movieName);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void removeMovie(String movieName) {
        Node temp = head;
        while (temp != null) {
            if (temp.movieName.equals(movieName)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next; // Removing the head
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void searchMovie(String movieName) {
        Node temp = head;
        while (temp != null) {
            if (temp.movieName.equals(movieName)) {
                System.out.println("Movie found: " + movieName);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found: " + movieName);
    }

    public void displayMovies() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.movieName);
            temp = temp.next;
        }
    }

    public void updateRating(String movieName, double newRating) {
        // This method can be implemented to update the rating of a movie.
        // For simplicity, ratings are not stored in this implementation.
    }

    public static void main(String[] args) {
        MoviemanagementUsingDoublyLL movieList = new MoviemanagementUsingDoublyLL();
        movieList.addMovie("Inception");
        movieList.addMovie("The Matrix");
        movieList.addMovie("Interstellar");

        System.out.println("Movies in the list:");
        movieList.displayMovies();
    }
}
