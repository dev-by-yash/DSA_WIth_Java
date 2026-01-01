//package tree;
//
//import heap.Heap; // Custom implementation
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//public class HuffmanCoding {
//    HashMap<Character, String> encoding;
//    HashMap<String, Character> decoding;
//
//    private class Node implements Comparable<Node> {
//        Character data;
//        int cost;
//        Node left;
//        Node right;
//
//        Node(Character data, int cost) {
//            this.data = data;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Node other) {
//            return this.cost - other.cost;
//        }
//    }
//
//    public HuffmanCoding(String feeder) {
//        // Frequency map
//        HashMap<Character, Integer> fmap = new HashMap<>();
//        for (char ch : feeder.toCharArray()) {
//            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
//        }
//
//        Heap<Node> minHeap = new Heap<>();
//
//        for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
//            Node node = new Node(entry.getKey(), entry.getValue());
//            minHeap.insert(node);
//        }
//
//        // Build Huffman Tree
//        while (minHeap.size() > 1) {
//            Node first = minHeap.remove();
//            Node second = minHeap.remove();
//
//            Node newNode = new Node('\0', first.cost + second.cost);
//            newNode.left = first;
//            newNode.right = second;
//
//            minHeap.insert(newNode);
//        }
//
//        Node root = minHeap.remove();
//
//        this.encoding = new HashMap<>();
//        this.decoding = new HashMap<>();
//
//        initEncoderDecoder(root, "");
//    }
//
//    private void initEncoderDecoder(Node node, String path) {
//        if (node == null) return;
//
//        if (node.left == null && node.right == null) {
//            encoding.put(node.data, path);
//            decoding.put(path, node.data);
//            return;
//        }
//
//        initEncoderDecoder(node.left, path + "0");
//        initEncoderDecoder(node.right, path + "1");
//    }
//
//    public String encode(String source) {
//        StringBuilder sb = new StringBuilder();
//        for (char ch : source.toCharArray()) {
//            sb.append(encoding.get(ch));
//        }
//        return sb.toString();
//    }
//
//    public String decode(String code) {
//        StringBuilder key = new StringBuilder();
//        StringBuilder result = new StringBuilder();
//
//        for (char ch : code.toCharArray()) {
//            key.append(ch);
//            if (decoding.containsKey(key.toString())) {
//                result.append(decoding.get(key.toString()));
//                key.setLength(0);
//            }
//        }
//
//        return result.toString();
//    }
//
//    public static void main(String[] args) {
//        String input = "abbccda";
//        HuffmanCoding hf = new HuffmanCoding(input);
//        String encoded = hf.encode(input);
//        System.out.println("Encoded: " + encoded);
//        String decoded = hf.decode(encoded);
//        System.out.println("Decoded: " + decoded);
//    }
//}
