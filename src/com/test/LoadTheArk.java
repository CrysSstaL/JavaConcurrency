package src.com.test;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class LoadTheArk {
    Ark ark = new Ark();

    public int loadTheArk(Collection<Animal> candidates){
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        // не дайте animals ускользнуть
        animals = new TreeSet<Animal>(
                // получаем животных
        );
        // при присваивании элементов в локальную переменную
        // ссылка на нее сохраняется локально и следовательно
        // ограничивается выполнющимся потоком
        animals.addAll(candidates);
        for (Animal a: animals){
            if (candidate == null || !candidate.isPotentialMate(a)){
                candidate = a;
            }
            else {
                ark.load(new AnimalPair(candidate, a));
                ++numPairs;
                candidate = null;
            }
        }

        return numPairs;
    };
    public static class Ark{

        public void load(AnimalPair animalPair){
            //
        }
    }
}
