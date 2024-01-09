package nextstep.courses.domain.session;

import nextstep.courses.exception.ImageException;

import java.util.Objects;

public class ImageInfo {
    private static final double MAXIMUM_FILE_SIZE_MB = 1;
    private static final int MINIMUM_WIDTH_PX = 300;
    private static final int MINIMUM_HEIGHT_PX = 200;

    private ImageType type;

    private ImageFileSize imageFileSize;

    private ImageSize imageSize;

    public ImageInfo(ImageType imageType, ImageFileSize imageFileSize, ImageSize imageSize) {
        this.type = imageType;
        this.imageFileSize = imageFileSize;
        this.imageSize = imageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageInfo imageInfo = (ImageInfo) o;
        return type == imageInfo.type && Objects.equals(imageFileSize, imageInfo.imageFileSize) && Objects.equals(imageSize, imageInfo.imageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, imageFileSize, imageSize);
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "type=" + type +
                ", imageFileSize=" + imageFileSize +
                ", imageSize=" + imageSize +
                '}';
    }
}