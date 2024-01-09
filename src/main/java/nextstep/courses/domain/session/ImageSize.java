package nextstep.courses.domain.session;

import nextstep.courses.exception.ImageException;

import java.util.Objects;

public class ImageSize {
    private static final int MINIMUM_WIDTH_PX = 300;
    private static final int MINIMUM_HEIGHT_PX = 200;

    private int width;

    private int height;

    public ImageSize(int width, int height) {
        isSupportImageSize(width, height);
        this.width = width;
        this.height = height;
    }

    private void isSupportImageSize(int width, int height) {
        if(width < MINIMUM_WIDTH_PX || height < MINIMUM_HEIGHT_PX) {
            throw new ImageException("이미지의 가로 길이는 300픽셀, 세로 길이는 200픽셀 이상이어야 합니다.");
        }

        if(isSupportImageRatio(width, height)) {
            throw new ImageException("이미지의 가로와 세로의 비율이 3:2가 아닙니다.");
        }
    }

    private boolean isSupportImageRatio(int width, int height) {
        return width * 2 != height * 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageSize imageSize = (ImageSize) o;
        return width == imageSize.width && height == imageSize.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "ImageSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
