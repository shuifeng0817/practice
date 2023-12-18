package cn.dfxy.shiyan;

import java.util.ArrayList;
import java.util.List;

    // AnimalBehavior接口
    interface AnimalBehavior {
        void makeSound();
        void run();
    }

    // 抽象类CatFamilyAnimal
    abstract class CatFamilyAnimal {
        private String furType;

        public String getFurType() {
            return furType;
        }

        public void setFurType(String furType) {
            this.furType = furType;
        }

        abstract void showHabitat();

        public abstract void makeSound();
    }

    // 狮子类
    class Lion extends CatFamilyAnimal implements AnimalBehavior {
        public Lion() {
            setFurType("长发");
        }

        public Lion(String furType) {
            setFurType(furType);
        }

        @Override
        public void makeSound() {
            System.out.println("狮子发出吼叫声");
        }

        @Override
        public void run() {
            System.out.println("狮子在奔跑");
        }

        @Override
        void showHabitat() {
            System.out.println("狮子属于群居动物");
        }
    }

    // 老虎类
    class Tiger extends CatFamilyAnimal implements AnimalBehavior {
        @Override
        public void makeSound() {
            System.out.println("老虎发出咆哮声");
        }

        @Override
        public void run() {
            System.out.println("老虎在奔跑");
        }

        @Override
        void showHabitat() {
            System.out.println("老虎属于孤居动物");
        }
    }

    // 犬科动物抽象类
    abstract class CanineAnimal implements AnimalBehavior {
        // 省略实现
    }

    // 狼类
    class Wolf extends CanineAnimal {
        @Override
        public void makeSound() {
            System.out.println("狼发出嗷嗷声");
        }

        @Override
        public void run() {
            System.out.println("狼在奔跑");
        }
    }

    // 狗类
    class Dog extends CanineAnimal {
        @Override
        public void makeSound() {
            System.out.println("狗发出汪汪声");
        }

        @Override
        public void run() {
            System.out.println("狗在奔跑");
        }
    }

    // 主类
    public class Main {
        public static void main(String[] args) {
            List<CatFamilyAnimal> catFamilyAnimals = new ArrayList<>();
            catFamilyAnimals.add(new Lion());
            catFamilyAnimals.add(new Lion("短发"));
            catFamilyAnimals.add(new Tiger());
            catFamilyAnimals.add(new Tiger());

            for (CatFamilyAnimal animal : catFamilyAnimals) {
                animal.makeSound();
                if (animal instanceof Lion) {
                    System.out.println("狮子的发型为：" + ((Lion) animal).getFurType());
                    ((Lion) animal).showHabitat();
                }
            }

            List<CanineAnimal> canineAnimals = new ArrayList<>();
            canineAnimals.add(new Wolf());
            canineAnimals.add(new Wolf());
            canineAnimals.add(new Dog());
            canineAnimals.add(new Dog());

            for (CanineAnimal animal : canineAnimals) {
                animal.makeSound();
            }
        }
    }

    

