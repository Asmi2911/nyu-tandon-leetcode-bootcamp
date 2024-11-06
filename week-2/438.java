//Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();

        if(s.length()<p.length()){ //base case
            return ans;
        }
        
        for (int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch,0)+1);
        }

        for (int i=0;i<p.length();i++){
            char ch = s.charAt(i);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
        }

        int i=p.length();
        int count=0;


        while (i<s.length()){
            if (comparemap(pmap, smap)){
                count++;
                ans.add(i-p.length());
            }

            char cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha,0)+1);

            char chr = s.charAt(i-p.length());
            if (smap.get(chr)==1){
                smap.remove(chr);
            }else{
                smap.put(chr,smap.get(chr)-1);
            }
            i++;
        }

        if (comparemap(pmap,smap)){
            count++;
            ans.add(i-p.length());
        }

        return ans;
    }

    private static boolean comparemap(HashMap<Character, Integer> pmap, HashMap<Character, Integer> smap) {
        for (char sch : smap.keySet()){
            if (!Objects.equals(pmap.getOrDefault(sch, 0), smap.get(sch))){
                return false;
            }
        }
        return true;
    }

    }
