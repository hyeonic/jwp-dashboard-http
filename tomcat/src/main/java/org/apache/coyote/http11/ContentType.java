package org.apache.coyote.http11;

import java.util.Arrays;
import org.apache.coyote.http11.exception.NoSuchContentTypeException;

public enum ContentType {

    HTML(".html", "text/html;charset=utf-8"),
    CSS(".css", "text/css"),
    JAVASCRIPT(".js", "application/javascript"),
    SVG(".svg", "image/svg+xml");

    private final String extension;
    private final String value;


    ContentType(final String extension, final String value) {
        this.extension = extension;
        this.value = value;
    }

    public static ContentType from(final String extension) {
        return Arrays.stream(values())
                .filter(contentType -> contentType.extension.equals(extension))
                .findFirst()
                .orElseThrow(NoSuchContentTypeException::new);
    }

    public String getExtension() {
        return extension;
    }

    public String getValue() {
        return value;
    }
}
