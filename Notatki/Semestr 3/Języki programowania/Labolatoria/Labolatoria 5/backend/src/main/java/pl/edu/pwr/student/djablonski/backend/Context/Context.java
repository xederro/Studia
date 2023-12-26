package pl.edu.pwr.student.djablonski.backend.Context;

import java.util.Random;

public abstract class Context {
    private static final Random RANDOM;
    private static int COUNT_OF_PAINTERS = 5;
    private static int COUNT_OF_SEGMENTS = 5;
    private static int COUNT_OF_PLANKS_IN_SEGMENT = 6;
    private static int COUNT_OF_PLANKS_PER_BUCKET = 4;
    private static int COUNT_OF_BUCKETS_IN_TANK = 4;
    private static int DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS = 4;
    private static int TIME_BETWEEN_PRINTS = 1000;
    private static int DURATION_OF_WORKER_OPERATION = 1000;
    private static int DURATION_OF_FILLING_PAINT_CONTAINER = 8000;
    private static int DURATION_OF_FILLING_BUCKET = 4000;

    static {
        RANDOM = new Random();
    }

    public static int TimeBetweenPrints() {
        return (int) (TIME_BETWEEN_PRINTS + RANDOM.nextFloat(0.75F,1.25F));
    }

    public static int DurationOfWorkerOperation() {
        return (int) (DURATION_OF_WORKER_OPERATION + RANDOM.nextFloat(0.75F,1.25F));
    }

    public static int DurationOfFillingPaintContainer() {
        return (int) (DURATION_OF_FILLING_PAINT_CONTAINER + RANDOM.nextFloat(0.75F,1.25F));
    }

    public static int DurationOfFillingBucket() {
        return (int) (DURATION_OF_FILLING_BUCKET + RANDOM.nextFloat(0.75F,1.25F));
    }

    public static void TimeBetweenPrints(int timeBetweenPrints) {
        TIME_BETWEEN_PRINTS = timeBetweenPrints;
    }

    public static void DurationOfWorkerOperation(int durationOfWorkerOperation) {
        DURATION_OF_WORKER_OPERATION = durationOfWorkerOperation;
    }

    public static void DurationOfFillingPaintContainer(int durationOfFillingPaintContainer) {
        DURATION_OF_FILLING_PAINT_CONTAINER = durationOfFillingPaintContainer;
    }

    public static void DurationOfFillingBucket(int durationOfFillingBucket) {
        DURATION_OF_FILLING_BUCKET = durationOfFillingBucket;
    }

    public static int CountOfPainters() {
        return COUNT_OF_PAINTERS;
    }

    public static void CountOfPainters(int countOfPainters) {
        COUNT_OF_PAINTERS = countOfPainters;
    }

    public static int CountOfSegments() {
        return COUNT_OF_SEGMENTS;
    }

    public static void CountOfSegments(int countOfSegments) {
        COUNT_OF_SEGMENTS = countOfSegments;
    }

    public static int CountOfPlanksInSegment() {
        return COUNT_OF_PLANKS_IN_SEGMENT;
    }

    public static void CountOfPlanksInSegment(int countOfPlanksInSegment) {
        COUNT_OF_PLANKS_IN_SEGMENT = countOfPlanksInSegment;
    }

    public static int CountOfPlanksPerBucket() {
        return COUNT_OF_PLANKS_PER_BUCKET;
    }

    public static void CountOfPlanksPerBucket(int countOfPlanksPerBucket) {
        COUNT_OF_PLANKS_PER_BUCKET = countOfPlanksPerBucket;
    }

    public static int CountOfBucketsInTank() {
        return COUNT_OF_BUCKETS_IN_TANK;
    }

    public static void CountOfBucketsInTank(int countOfBucketsInTank) {
        COUNT_OF_BUCKETS_IN_TANK = countOfBucketsInTank;
    }

    public static int DistanceBetweenPaintproducerAndPainters() {
        return DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS;
    }

    public static void DistanceBetweenPaintproducerAndPainters(int distanceBetweenPaintproducerAndPainters) {
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS = distanceBetweenPaintproducerAndPainters;
    }
}
