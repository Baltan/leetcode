package leetcode.algorithms;

/**
 * Description: 1603. Design Parking System
 *
 * @author Baltan
 * @date 2022/10/8 10:47
 */
public class ParkingSystem {
    /**
     * countArray[1]、countArray[2]、countArray[3]依次代表大中小三种车位的数量
     */
    private int[] countArray;

    public ParkingSystem(int big, int medium, int small) {
        countArray = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        countArray[carType]--;
        return countArray[carType] >= 0;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
