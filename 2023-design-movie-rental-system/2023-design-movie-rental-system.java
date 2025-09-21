class MovieRentingSystem {
    private static class Copy implements Comparable<Copy> {
        int shop, movie, price;
        public Copy(int shop, int movie, int price) {
            this.shop = shop; this.movie = movie; this.price = price;
        }
        public int compareTo(Copy o) {
            if (price != o.price) return price - o.price;
            if (shop != o.shop) return shop - o.shop;
            return movie - o.movie;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Copy)) return false;
            Copy c = (Copy)o;
            return shop == c.shop && movie == c.movie && price == c.price;
        }
        @Override
        public int hashCode() { return Objects.hash(shop, movie, price);}
    }

    Map<Integer, TreeSet<Copy>> unrented = new HashMap<>();
    TreeSet<Copy> rented = new TreeSet<>();
    Map<List<Integer>, Integer> priceMap = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(Arrays.asList(shop, movie), price);
            unrented.computeIfAbsent(movie, k -> new TreeSet<>()).add(new Copy(shop, movie, price));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!unrented.containsKey(movie)) return res;
        for (Copy c : unrented.get(movie)) {
            res.add(c.shop);
            if (res.size() == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(Arrays.asList(shop, movie));
        Copy c = new Copy(shop, movie, price);
        unrented.get(movie).remove(c);
        rented.add(c);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(Arrays.asList(shop, movie));
        Copy c = new Copy(shop, movie, price);
        rented.remove(c);
        unrented.get(movie).add(c);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        for (Copy c : rented) {
            result.add(Arrays.asList(c.shop, c.movie));
            if (result.size() == 5) break;
        }
        return result;
    }
}
