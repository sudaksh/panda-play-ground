package bambooSwords.BfsDfsTree;


import java.util.HashSet;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null) return true;
        int row = graph.length;
        int col = graph[0].length;
        int[][] edges = new int[row][row];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < graph[i].length; j++){
                edges[i][graph[i][j]] = 1;
            }
        }

        HashSet<Integer> g1 = new HashSet<>();
        HashSet<Integer> g2 = new HashSet<>();

        g1.add(0);

        for (int i = 1; i < row; i++){
            for (int j = 0; j < i; j++){
                if (edges[i][j] == 1){
                    if (g1.contains(i)){
                        g2.add(j);
                    } else if (g1.contains(j)){
                        g2.add(i);
                    } else if (g2.contains(i)){
                        g1.add(j);
                    } else if (g2.contains(j)){
                        g1.add(i);
                    } else {
                        g1.add(j);
                        g2.add(i);
                    }
                    if (g1.contains(i) && g1.contains(j)) return false;
                    if (g2.contains(i) && g2.contains(j)) return false;
                }
            }
        }
        return true;

    }
}
