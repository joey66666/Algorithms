/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <p>
 * Implement the FirstUnique class:
 * <p>
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 */


/*
 * Use doubly Linked list with hashmap of pointers to linked list nodes.
 * add unique number to the linked list.
 * When add is called check if the added number is unique
 * then it have to be added to the linked list and
 * if it is repeated remove it from the linked list if exists.
 * When showFirstUnique is called retrieve the head of the linked list.
 * */
class DoubleLinkedNode {
    Object value;
    DoubleLinkedNode prev = null;
    DoubleLinkedNode next = null;

    public DoubleLinkedNode(Object value) {
        this.value = value;
    }
}

class DoubleLinkedList {
    DoubleLinkedNode sentinel = new DoubleLinkedNode(null);
    DoubleLinkedNode tail = sentinel;

    public void addNode(DoubleLinkedNode node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void removeNode(DoubleLinkedNode node) {
        if (node.next == null && node.prev == null) return;
        node.prev.next = node.next;
        if (node.next == null) tail = node.prev;
        else node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public int getHead() {
        if (sentinel.next == null) return -1;
        else return (int) sentinel.next.value;
    }

}


class FirstUnique {
    HashMap<Integer, DoubleLinkedNode> hm = new HashMap<>();
    DoubleLinkedList list = new DoubleLinkedList();

    public FirstUnique(int[] nums) {
        if (nums == null || nums.length == 0) return;
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!hm.containsKey(nums[i])) {
                    DoubleLinkedNode node = new DoubleLinkedNode(nums[i]);
                    list.addNode(node);
                    hm.put(nums[i], node);
                } else {
                    DoubleLinkedNode node = hm.get(nums[i]);
                    list.removeNode(node);
                }
            }
        }
    }

    public int showFirstUnique() {
        return list.getHead();
    }

    public void add(int value) {
        // value is unique
        if (!hm.containsKey(value)) {
            DoubleLinkedNode node = new DoubleLinkedNode(value);
            list.addNode(node);
            hm.put(value, node);
        } else {
            DoubleLinkedNode node = hm.get(value);
            list.removeNode(node);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */


