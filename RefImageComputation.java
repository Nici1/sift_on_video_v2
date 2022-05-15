package com.example.diplomska_v2;

import org.opencv.core.DMatch;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.Features2d;
import org.opencv.features2d.SIFT;
import org.opencv.imgproc.Imgproc;
import java.util.ArrayList;
import java.util.List;

public class RefImageComputation {

    public static Mat [] compute(Mat a) {


        Mat img1 = new Mat();
        Imgproc.cvtColor(a,img1,Imgproc.COLOR_BGR2GRAY);

        if (img1.empty()) {
            System.err.println("Cannot read images!");
            System.exit(0);
        }
        //-- Step 1: Detect the keypoints using SIFT Detector, compute the descriptors
        double hessianThreshold = 400;
        int nOctaves = 4, nOctaveLayers = 3;
        boolean extended = false, upright = false;
        SIFT detector = SIFT.create(400, 3, 0.09);
        MatOfKeyPoint keypoints1 = new MatOfKeyPoint();
        Mat descriptors1 = new Mat();
        detector.detectAndCompute(img1, new Mat(), keypoints1, descriptors1);

        Mat [] array={descriptors1,keypoints1,img1};
        return array;
    }
}
