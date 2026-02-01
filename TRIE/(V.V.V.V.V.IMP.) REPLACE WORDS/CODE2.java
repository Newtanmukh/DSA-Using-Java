class Solution {
    Trie root;

    class Trie{
        public Trie[] children;
        public boolean isEnd;

        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        root = new Trie();

        for(String word: dict){
            insert(word);
        }

        StringBuilder sb = new StringBuilder();
        String[] input = sentence.split(" ");

        for(String i: input){
            sb.append(search(i));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public void insert(String word){
        Trie node = root;
        char[] ch = word.toCharArray();
        // cat
        // root -> 'c' -> 'a' -> 't', 't' node is end and this isEnd = true.
        for(char c: ch){
            int i = c - 'a';

            if(node.children[i] == null){
                node.children[i] = new Trie();
            }

            node = node.children[i];
        }
        node.isEnd = true;
    }

    public String search(String word){
        Trie node = root;
        char[] ch = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: ch){
            int idx = c - 'a';

            if(node.children[idx] == null){
                return word;
            }

            node = node.children[idx];
            sb.append(c);

            if(node.isEnd){
                return sb.toString();
            }
        }

        return word;
    }

}