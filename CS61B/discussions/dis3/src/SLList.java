import javax.print.AttributeException;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /*
     * 在postion处插入x，若postion大于length则插在尾部
     * */
    public void insert(int item, int position) {
        IntNode node = first;
        for (int i = 0; i < position - 1; i++) {
            node = node.next;
            if (node.next == null) {
                node.next = new IntNode(item, null);
                break;
            }
        }

        IntNode insertNode = new IntNode(item, node.next);
        node.next = insertNode;
    }

    public void testInsert() {
        IntNode node = first;

        insert(10, 1);
        insert(10, 7);

        while (node.next != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }

    /* 迭代和递归都实现
     * */
    public void reverse() {
        // 迭代
        if (first == null | first.next == null) {
            return;
        }
        IntNode node = first.next;
        first.next = null;

        while (node != null) {
            IntNode temp = node.next;
            node.next = first;
            first = node;
            node = temp;
        }
    }

    public void reverse2() {
        // 递归
        if (first == null | first.next == null) {
            return;
        }
        first = reverseHelper(first);
    }

    public IntNode reverseHelper(IntNode last) {
        if (last == null | last.next == null) {
            return last;
        }
        IntNode endofReverse = last.next;
        IntNode reversed = reverseHelper(endofReverse);
        endofReverse.next = last;
        last.next = null;
        return reversed;
    }


    public static void main(String[] args) {
        SLList list = new SLList();
        list.addFirst(2);
        list.addFirst(6);
        list.addFirst(5);
        list.reverse2();
    }
}

