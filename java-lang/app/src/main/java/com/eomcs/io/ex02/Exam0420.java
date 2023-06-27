// FileInputStream 활용 - JPEG 파일 읽기 : 위도 경도 알아내기
package com.eomcs.io.ex02;

import java.io.File;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;

public class Exam0420 {

  public static void main(String[] args) throws Exception {

    // 1) 파일 정보를 준비한다.
    File file = new File("sample/gps-test.jpeg");

    Metadata metadata = ImageMetadataReader.readMetadata(file);
    GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);


    if (gpsDirectory != null) {
      System.out.println(gpsDirectory.getGeoLocation().getLatitude());
      System.out.println(gpsDirectory.getGeoLocation().getLongitude());
    }
  }
}
