package me.august.battlefield;

/**
 * Created by August on 4/10/14.
 */
public enum Ranks {

	RECRUIT(0),
	PRIVATE_FIRST_CLASS(1),
	PRIVATE_FIRST_CLASS_II(2),
	PRIVATE_FIRST_CLASS_III(3),
	PRIVATE_FIRST_CLASS_IV(4),
	PRIVATE_FIRST_CLASS_V(5),
	LANCE_CORPORAL(6),
	LANCE_CORPORAL_II(7),
	LANCE_CORPORAL_III(8),
	LANCE_CORPORAL_IV(9),
	LANCE_CORPORAL_V(10),
	CORPORAL(11),
	CORPORAL_II(12),
	CORPORAL_III(13),
	CORPORAL_IV(14),
	CORPORAL_V(15),
	SERGEANT(16),
	SERGEANT_II(17),
	SERGEANT_III(18),
	SERGEANT_IV(19),
	SERGEANT_V(20),
	STAFF_SERGEANT(21),
	STAFF_SERGEANT_II(22),
	STAFF_SERGEANT_III(23),
	STAFF_SERGEANT_IV(24),
	STAFF_SERGEANT_V(25),
	GUNNERY_SERGEANT(26),
	GUNNERY_SERGEANT_II(27),
	GUNNERY_SERGEANT_III(28),
	GUNNERY_SERGEANT_IV(29),
	GUNNERY_SERGEANT_V(30),
	MASTER_SERGEANT(31),
	MASTER_SERGEANT_II(32),
	MASTER_SERGEANT_III(33),
	MASTER_SERGEANT_IV(34),
	MASTER_SERGEANT_V(35),
	FIRST_SERGEANT(36),
	FIRST_SERGEANT_II(37),
	FIRST_SERGEANT_III(38),
	FIRST_SERGEANT_IV(39),
	FIRST_SERGEANT_V(40),
	MASTERY_GUNNERY_SERGEANT(41),
	MASTERY_GUNNERY_SERGEANT_II(42),
	MASTERY_GUNNERY_SERGEANT_III(43),
	MASTERY_GUNNERY_SERGEANT_IV(44),
	MASTERY_GUNNERY_SERGEANT_V(45),
	SERGEANT_MAJOR(46),
	SERGEANT_MAJOR_II(47),
	SERGEANT_MAJOR_III(48),
	SERGEANT_MAJOR_IV(49),
	SERGEANT_MAJOR_V(50),
	WARRANT_OFFICER_ONE(51),
	WARRANT_OFFICER_ONE_II(52),
	WARRANT_OFFICER_ONE_III(53),
	WARRANT_OFFICER_ONE_IV(54),
	WARRANT_OFFICER_ONE_V(55),
	CHIEF_WARRANT_OFFICER_TWO(56),
	CHIEF_WARRANT_OFFICER_TWO_II(57),
	CHIEF_WARRANT_OFFICER_TWO_III(58),
	CHIEF_WARRANT_OFFICER_TWO_IV(59),
	CHIEF_WARRANT_OFFICER_TWO_V(60),
	CHIEF_WARRANT_OFFICER_THREE(61),
	CHIEF_WARRANT_OFFICER_THREE_II(62),
	CHIEF_WARRANT_OFFICER_THREE_III(63),
	CHIEF_WARRANT_OFFICER_THREE_IV(64),
	CHIEF_WARRANT_OFFICER_THREE_V(65),
	CHIEF_WARRANT_OFFICER_FOUR(66),
	CHIEF_WARRANT_OFFICER_FOUR_II(67),
	CHIEF_WARRANT_OFFICER_FOUR_III(68),
	CHIEF_WARRANT_OFFICER_FOUR_IV(69),
	CHIEF_WARRANT_OFFICER_FOUR_V(70),
	CHIEF_WARRANT_OFFICER_FIVE(71),
	CHIEF_WARRANT_OFFICER_FIVE_II(72),
	CHIEF_WARRANT_OFFICER_FIVE_III(73),
	CHIEF_WARRANT_OFFICER_FIVE_IV(74),
	CHIEF_WARRANT_OFFICER_FIVE_V(75),
	SECOND_LIEUTENANT(76),
	SECOND_LIEUTENANT_II(77),
	SECOND_LIEUTENANT_III(78),
	SECOND_LIEUTENANT_IV(79),
	SECOND_LIEUTENANT_V(80),
	FIRST_LIEUTENANT(81),
	FIRST_LIEUTENANT_II(82),
	FIRST_LIEUTENANT_III(83),
	FIRST_LIEUTENANT_IV(84),
	FIRST_LIEUTENANT_V(85),
	CAPTAIN(86),
	CAPTAIN_II(87),
	CAPTAIN_III(88),
	CAPTAIN_IV(89),
	CAPTAIN_V(90),
	MAJOR(91),
	MAJOR_II(92),
	MAJOR_III(93),
	MAJOR_IV(94),
	MAJOR_V(95),
	LT_COLONEL(96),
	LT_COLONEL_II(97),
	LT_COLONEL_III(98),
	LT_COLONEL_IV(99),
	COLONEL(100),
	COLONEL_II(101),
	COLONEL_III(102),
	COLONEL_IV(103),
	COLONEL_V(104),
	COLONEL_VI(105),
	COLONEL_VII(106),
	COLONEL_VIII(107),
	COLONEL_IX(108),
	COLONEL_X(109),
	BRIGADIER_GENERAL(110),
	BRIGADIER_GENERAL_II(111),
	BRIGADIER_GENERAL_III(112),
	BRIGADIER_GENERAL_IV(113),
	BRIGADIER_GENERAL_V(114),
	BRIGADIER_GENERAL_VI(115),
	BRIGADIER_GENERAL_VII(116),
	BRIGADIER_GENERAL_VIII(117),
	BRIGADIER_GENERAL_IX(118),
	BRIGADIER_GENERAL_X(119),
	MAJOR_GENERAL(120)
	;

	private int rank;

	Ranks(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}
}