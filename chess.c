#include "chess.h"

int print_board()
{
	
	return 1;
}

int setup_screen()
{
	initscr();
	noecho();
	curs_set(FALSE);
	keypad(stdscr, TRUE);
	clear();
	refresh();
	sleep(1);
	return 1;
}

int cleanup_screen()
{
	clear();
	refresh();
	endwin();
	return 1;
}

int chess_piece_test()
{
	setlocale(LC_ALL, "");
	printf("##### Chess Pieces Test #####\n\n");
	printf("WHITE KING:\t%lc\n", WHITE_KING);
	printf("WHITE QUEEN:\t%lc\n", WHITE_QUEEN);
	printf("WHITE ROOK:\t%lc\n", WHITE_ROOK);
	printf("WHITE BISHOP:\t%lc\n", WHITE_BISHOP);
	printf("WHITE KNIGHT:\t%lc\n", WHITE_KNIGHT);
	printf("WHITE PAWN:\t%lc\n", WHITE_PAWN);
	printf("BLACK KING:\t%lc\n", BLACK_KING);
	printf("BLACK QUEEN:\t%lc\n", BLACK_QUEEN);
	printf("BLACK ROOK:\t%lc\n", BLACK_ROOK);
	printf("BLACK BISHOP:\t%lc\n", BLACK_BISHOP);
	printf("BLACK KNIGHT:\t%lc\n", BLACK_KNIGHT);
	printf("BLACK PAWN:\t%lc\n", BLACK_PAWN);
	return 1;
}
int main()
{
	setup_screen();
	sleep(10);
	cleanup_screen();
	return (0);
}
