import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Phase 
{
    LIQUID, SOLID, GAS, PLASMA;

    public enum Transition
    {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),   CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to)
        {
            this.from = from;
            this.to = to;
        }

        public static final Map<Phase, Map<Phase, Transition>> map =
            Stream.of(values()).collect
            (
                Collectors.groupingBy
                (
                    t -> t.from,
                    () -> new EnumMap<>(Phase.class),
                    Collectors.toMap
                    (
                        t -> t.to,
                        t -> t,
                        (x, y) -> y,
                        () -> new EnumMap<>(Phase.class)
                    )
                )
            );
        
        public static Optional<Transition> from(Phase from, Phase to)
        {
            return Optional.ofNullable(map.get(from)).map(innerMap -> innerMap.get(to));
        }
    }
}