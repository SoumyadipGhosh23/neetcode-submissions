class Car {
    int position;
    int speed;

    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

class Solution {

    private double calculateTime(int target, Car c) {
        return (target - c.position) / (double) c.speed;
    }

    public int carFleet(int target, int[] position, int[] speed) {

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        // Sort by position descending
        cars.sort((a, b) -> b.position - a.position);

        int fleetCount = 0;
        double fleetTime = 0;

        for (int i = 0; i < cars.size(); i++) {
            double currentTime = calculateTime(target, cars.get(i));

            if (currentTime > fleetTime) {
                fleetCount++;
                fleetTime = currentTime;
            }
        }

        return fleetCount;
    }
}