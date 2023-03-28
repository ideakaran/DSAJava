package oldpractice;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode(); //root is empty
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26]; //storing english words -a -> z
            this.isWord = false;
        }
    }


    public boolean startsWith(String prefix) {
        boolean startsWith = true;
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            current = current.children[index];

            if(current == null) {
                return false;
            }
        }
        return startsWith;

//        TrieNode it = root;
//        for(char c : prefix.toCharArray()){
//            int indexInTrieNode = c - 'a';
//            if(it.children[indexInTrieNode] == null){
//                return false;
//            } else{
//                it = it.children[indexInTrieNode];
//            }
//        }
//        return true;
    }


    public void insert(String word) {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }
        }
        current.isWord = true;

    }

    public boolean search(String word) {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index] == null) {
                return false;
            } else {
                current = current.children[index];
            }
        }
        return current.isWord;
    }

    public  TrieNode delete(String word) {
       TrieNode current = root;
       TrieNode deletedNode = deleteNode(current, word, 0);
       return deletedNode;
    }

    private TrieNode deleteNode(TrieNode root, String word, int depth) {

        if(root == null) {
            return null;
        }
        if(depth == word.length()) {
            if(root.isWord)
                root.isWord = false;
            if(isEmpty(root)) {
                root = null;
            }
            return root;
        }
        char currentChar = word.charAt(depth);
        int index = currentChar - 'a';
        root.children[index] = deleteNode(root.children[index], word, depth + 1);
        if (isEmpty(root) && root.isWord == false) {
            root = null;
        }
        return root;

    }

    private boolean isEmpty(TrieNode root) {


        boolean isEmpty = true;
        if(root == null) {
            return isEmpty;
        }
        for (int i = 0; i < root.children.length; i++) {
            TrieNode child= root.children[i];
            if(child != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }





    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println("Value inserted successfully");
        boolean startWithca = trie.startsWith("app");
        System.out.println("startWithca = " + startWithca);


    }
}
