package net.jordimp.katas.streams;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecycleStream {

    private RecycleStream() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RecycleStream.class);

    private static final Pattern NEWLINE = Pattern.compile("\n");
    private static final Pattern COMMA = Pattern.compile(",");

    public static int[] extract(final String text) {

        final boolean[] isEven = { false };

        final List<String> list = NEWLINE.splitAsStream(text).collect(Collectors.toList());
        // -> Stream.of() / Arrays.stream()

        list.stream().filter(w -> !w.startsWith("#")).skip(1).filter(l -> isEven[0] = !isEven[0])
            .forEach(LOGGER::debug);

        isEven[0] = false;

        // @formatter:off
        final IntStream col = list.stream()
            .filter(w -> !w.startsWith("#"))
            .skip(1)
            .filter(l -> isEven[0] = !isEven[0])
            .map(line-> COMMA.splitAsStream(line).skip(2).findFirst().get())
            .mapToInt(Integer::parseInt);
        // @formatter:on

        return col.toArray();
    }

}
