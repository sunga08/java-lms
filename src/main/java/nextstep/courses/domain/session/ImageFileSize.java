package nextstep.courses.domain.session;

import nextstep.courses.exception.ImageException;

import java.util.Objects;

public class ImageFileSize {
    private static final double MAXIMUM_FILE_SIZE_MB = 1;

    private double size;

    public ImageFileSize(double size) {
        isSupportFileSize(size);
        this.size = size;
    }

    private void isSupportFileSize(double size) {
        if (size > MAXIMUM_FILE_SIZE_MB) {
            throw new ImageException("이미지 크기가 1MB를 초과하였습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageFileSize that = (ImageFileSize) o;
        return Double.compare(that.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "ImageFileSize{" +
                "size=" + size +
                '}';
    }
}
