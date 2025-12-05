public class Sorter {
    private SortStrategy sortStrategy;

    public Sorter(SortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public String getSortStrategyName(){
        return sortStrategy.getAlgorithmName();
    }

    public void sort(int[] array){
        sortStrategy.sort(array);
    }
}
