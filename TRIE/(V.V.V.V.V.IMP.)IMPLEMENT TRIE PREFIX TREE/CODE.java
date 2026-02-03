// problem statement : https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {

    public class Node{
        public Node[] children;
        public boolean isWord;

        Node(){
            children = new Node[26];
            isWord = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }



    public void insert(String word) {
        Node node = root;

        char[] ch = word.toCharArray();
        for(char c: ch){
            int idx = c - 'a';
            if(node.children[idx]==null)
                node.children[idx] = new Node();

            node = node.children[idx];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;

        char[] ch = word.toCharArray();

        for(char c: ch){
            int idx = c - 'a';
            if(node.children[idx]==null)
                return false;

            node = node.children[idx];
        }



        return node.isWord;
    }

    public boolean startsWith(String word) {
        Node node = root;

        char[] ch = word.toCharArray();

        for(char c: ch){
            int idx = c - 'a';
            if(node.children[idx]==null)
                return false;

            node = node.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */