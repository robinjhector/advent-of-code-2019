import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class Day1 {

    private static final boolean USE_FUEL_FOR_FUEL_MASS = false; //This is part 1 = false / part 2 = true of the puzzle

    public static void main(final String[] args) throws Exception {
        final List<Integer> input = getInput();

        final BigDecimal totalFuel = input.stream()
            .map(BigDecimal::valueOf)
            .map(Day1::getFuel)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(totalFuel);
    }

    private static BigDecimal getFuel(final BigDecimal mass) {
        final BigDecimal fuel = mass
            .divide(BigDecimal.valueOf(3), RoundingMode.DOWN)
            .subtract(BigDecimal.valueOf(2));
        if (!USE_FUEL_FOR_FUEL_MASS) {
            return fuel;
        }
        if (fuel.compareTo(BigDecimal.ZERO) >= 0) {
            return fuel.add(getFuel(fuel));
        }
        return BigDecimal.ZERO;
    }

    private static List<Integer> getInput() {
        return List.of(
            50062,
            118298,
            106698,
            59751,
            59461,
            144411,
            52783,
            118293,
            148025,
            54354,
            95296,
            68478,
            80105,
            76390,
            75768,
            89311,
            117129,
            127515,
            131531,
            127565,
            77249,
            91806,
            123811,
            123508,
            127263,
            61076,
            82153,
            122561,
            89117,
            116790,
            146530,
            66706,
            56549,
            112264,
            139250,
            87331,
            144022,
            142052,
            125519,
            89797,
            85148,
            125388,
            67458,
            116066,
            74346,
            148163,
            55477,
            146163,
            99308,
            95653,
            122175,
            92021,
            146532,
            109749,
            136711,
            102321,
            114221,
            140294,
            116718,
            127416,
            130402,
            52239,
            125181,
            146410,
            126339,
            147221,
            81706,
            80131,
            140909,
            59935,
            71878,
            64434,
            148450,
            73037,
            90890,
            137135,
            85992,
            137381,
            84604,
            62524,
            64133,
            92067,
            124269,
            132039,
            145257,
            107367,
            62143,
            105000,
            62124,
            55929,
            101489,
            94728,
            85982,
            88358,
            83275,
            132648,
            75688,
            109263,
            146400,
            114701
        );
    }
}
