package nextstep.courses.domain;

import nextstep.courses.domain.session.ImageFileSize;
import nextstep.courses.domain.session.ImageInfo;
import nextstep.courses.domain.session.ImageSize;
import nextstep.courses.domain.session.ImageType;
import nextstep.courses.exception.ImageException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ImageInfoTest {

    @Test
    @DisplayName("이미지 용량이 1MB를 초과하면 예외가 발생한다. ")
    void 이미지_용량_체크() {
        assertThatThrownBy(() -> new ImageInfo(ImageType.isSupportImageType("GIF"), new ImageFileSize(2), new ImageSize(0,0)))
                .isInstanceOf(ImageException.class);
    }

    @Test
    @DisplayName("이미지의 가로가 300픽셀, 세로가 200픽셀 이상이 아니면 예외를 발생한다.")
    void 이미지_길이_체크() {
        assertThatThrownBy(() -> new ImageInfo(ImageType.isSupportImageType("GIF"), new ImageFileSize(1), new ImageSize(270,180)))
                .isInstanceOf(ImageException.class);
    }

    @Test
    @DisplayName("이미지의 가로와 세로의 비율이 3:2가 아니면 예외를 발생한다.")
    void 이미지_길이_비율_체크() {
        assertThatThrownBy(() -> new ImageInfo(ImageType.isSupportImageType("GIF"), new ImageFileSize(1), new ImageSize(300,400)))
                .isInstanceOf(ImageException.class);
    }

    @Test
    @DisplayName("잘못된 이미지 형식이 들어오면 예외를 반환한다.")
    void 이미지_형식_체크() {
        assertThatThrownBy(() -> new ImageInfo(ImageType.isSupportImageType("TXT"), new ImageFileSize(1), new ImageSize(300,200)))
                .isInstanceOf(ImageException.class);
    }
}
