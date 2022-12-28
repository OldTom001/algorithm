import java.util.LinkedList;
import java.util.List;


class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> oneCom = new LinkedList();
        for(int i = 1; i<=n ;i++){
            backtracking(res, oneCom, i, n, k);
        }
        return res;

    }
    public void backtracking(List<List<Integer>> res, List<Integer> oneCom, int start, int n, int k){
        oneCom.add(start);
        if(oneCom.size()==k){
            res.add(new LinkedList(oneCom));
            return;
        }
    
        for(int i = start+1; i<=n; i++){
            backtracking(res, oneCom, i, n, k);
            System.out.println(res);
            oneCom.remove(oneCom.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        Combinations c = new Combinations();
        c.combine(n, k);
        
    }
}