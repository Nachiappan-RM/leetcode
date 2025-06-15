// class Solution {
//     /**
//     target, position = [], speed = []
//     [10, 8, 0, 5, 3]
//     [10, _, _, _, _]
//     [10+2, 8+4, 0+1, 5+1, 3+3] = [12, 12, 1, 6, 6] <- At some point it converge

//     All positions are unique
//     [0, 3, 5, 8, 10] <-> [1, 3, 1, 4, 2] <- Trying to see whether I can use Treemap

//     speed[i] * (x) + position[i] =  speed[j] * y + position[j]
//     Both of those is <= target

//     if(val == target){
//         x = target - position[i])
//     }

//     [1, 0, 0, 3, 0, 1, 0, 0, 4, 0, 2, 0, 0]
//     if the next one is bigger -> add one to fleet
//     else ->
//      */
//     class Car {
//         int position;
//         int speed;
//         double time;

//         public Car(int position, int speed, double time) {
//             this.position = position;
//             this.speed = speed;
//             this.time = time;
//         }
//     }

//     public int carFleet(int target, int[] position, int[] speed) {
//         int n = position.length;
//         if (n <= 1)
//             return n;

//         Stack<Car> stack = new Stack<>();
//         List<Car> carList = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             carList.add(new Car(position[i], speed[i], (double)(target - position[i]) / speed[i]));
//         }
//         Collections.sort(carList, new Comparator<Car>() {
//             @Override
//             public int compare(Car c1, Car c2) {
//                 return Integer.compare(c2.position, c1.position); //Reverse sort based on position
//             }
//         });

//         for (Car car : carList) {
//             if (!stack.isEmpty()) {
//                 Car top = stack.peek();
//                 if (car.time <= top.time) { //If curr car reaches the destination is lesser than top don't add it to the stack
//                     continue;
//                 }
//             }
//             stack.push(car);
//         }
//         return stack.size();
//     }
// }

// -------REVISION---------
class Solution {
    /**
    Sort based on the positions,
    
    target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
    
    after sorted,
    [(0,1), (3, 3), (5,1), (8, 4), (10,2)]
    
     */
    class Car {
        int position;
        int speed;
        double time;

        public Car(int position, int speed, double time) {
            this.position = position;
            this.speed = speed;
            this.time = time;
        }

        @Override
        public String toString() {
            return "position->" + position + " speed->" + speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>();
        if (n <= 1) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i], (double) (target - position[i]) / (double) (speed[i])));
        }
        //Reverse sort the position
        Collections.sort(cars, (c1, c2) -> Integer.compare(c2.position, c1.position));
        // System.out.println(cars);
        Stack<Car> stack = new Stack<>();
        for (Car c : cars) {
            if(stack.isEmpty() || c.time>stack.peek().time) {
                stack.push(c);
            }           
        }
        return stack.size();
    }
}