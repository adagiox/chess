#include "chess.h"

int main()
{
	setlocale(LC_ALL, "");
	printf("##### Chess Pieces Test #####\n\n");
	printf("WHITE KING:\t%lc\n", 0x2654);
	printf("WHITE QUEEN:\t%lc\n", 0x2655);
	printf("WHITE ROOK:\t%lc\n", 0x2656);
	printf("WHITE BISHOP:\t%lc\n", 0x2657);
	printf("WHITE KNIGHT:\t%lc\n", 0x2658);
	printf("WHITE PAWN:\t%lc\n", 0x2659);
	printf("BLACK KING:\t%lc\n", 0x265A);
	printf("BLACK QUEEN:\t%lc\n", 0x265B);
	printf("BLACK ROOK:\t%lc\n", 0x265C);
	printf("BLACK BISHOP:\t%lc\n", 0x265D);
	printf("BLACK KNIGHT:\t%lc\n", 0x265E);
	printf("BLACK PAWN:\t%lc\n", 0x265F);
	return (0);
}
