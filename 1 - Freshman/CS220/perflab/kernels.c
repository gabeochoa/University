/********************************************************
 * Kernels to be optimized for the CS:APP Performance Lab
 ********************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "defs.h"

/* 
 * Please fill in the following team struct 
 */
team_t team = {
    "ochoa",              /* Team name */

    "Gabriel Ochoa",     /* First member full name */
    "gochoa1@binghamton.edu",  /* First member email address */

    "",                   /* Second member full name (leave blank if none) */
    ""                    /* Second member email addr (leave blank if none) */
};

/***************
 * ROTATE KERNEL
 ***************/

/******************************************************
 * Your different versions of the rotate kernel go here
 ******************************************************/

/* 
 * naive_rotate - The naive baseline version of rotate 
 */
char naive_rotate_descr[] = "naive_rotate: Naive baseline implementation";
void naive_rotate(int dim, pixel *src, pixel *dst) 
{
    int i, j;

    for (i = 0; i < dim; i++)
	for (j = 0; j < dim; j++)
	    dst[RIDX(dim-1-j, i, dim)] = src[RIDX(i, j, dim)];
}

//1) original matrix
//
//1 2 3
//4 5 6
//7 8 9
//
//2) transpose
//
//1 4 7
//2 5 8
//3 6 9
//
//3-a) change rows to rotate left
//
//3 6 9
//2 5 8
//1 4 7
//
//3-b) or change columns to rotate right
//
//7 4 1
//8 5 2
//9 6 3


/* 
 * rotate - Your current working version of rotate
 * IMPORTANT: This is the version you will be graded on
 */
char rotate_descr[] = "rotate: Current working version";
void rotate(int dim, pixel *src, pixel *dst) 
{
   //naive_rotate(dim, src, dst);
	int i, j, a, b;
//
//	for(a = 0; a < dim; a += 8)
//       for(b = 0; b < dim; b += 8)
//            for (i = a; i < a + 8; i++)   
//              for (j = b; j < b + 8; j++)
//                {
//				   dst[RIDX(dim-1-j, i, dim)] = src[RIDX(i, j, dim)];
//				}
    
    int midR = dim/2;
    int midC = dim/2;
    pixel temp;
    
    for(a = 0; a<midR-1; a++)
        for(b = 0; b<midC-1; b++){
            temp = src[RIDX(i,j,dim)];
            dst[RIDX(i,j,dim)] = src[RIDX(j,dim-i-1,dim)];
            dst[RIDX(j,dim-1-i,dim)] = src[RIDX(dim-1-i,dim-1-j,dim)];
            dst[RIDX(dim-1-i,dim-1-j,dim)] = src[RIDX(dim-1-j,i,dim)];
            dst[RIDX(dim-1-j,i,dim)] = temp;
        }
}

/*
 * rotate2 - Your current working version of rotate
 * IMPORTANT: This is the version you will be graded on
 */
char rotate2_descr[] = "rotate 2: Scored 1.1";
void rotate2(int dim, pixel *src, pixel *dst) 
{
   //naive_rotate(dim, src, dst);
	int i, j, a, b;

	for(a = 0; a < dim; a += 8)
       for(b = 0; b < dim; b += 8)
              for (i = a; i < a + 8; i++)   
              for (j = b; j < b + 8; j++)
                {
				   dst[RIDX(dim-1-j, i, dim)] = src[RIDX(i, j, dim)];
				}
	
}
/*
				   dst[RIDX(dim-1-j+, i+, dim)] = src[RIDX(i+, j+, dim)];
				   dst[RIDX(dim-1-j+, i+, dim)] = src[RIDX(i+, j+, dim)];
				   dst[RIDX(dim-1-j+, i+, dim)] = src[RIDX(i+, j+, dim)];
				   dst[RIDX(dim-1-j+, i+, dim)] = src[RIDX(i+, j+, dim)];
				   dst[RIDX(dim-1-j+, i+, dim)] = src[RIDX(i+, j+, dim)];
				   dst[RIDX(dim-1-j+, i+, dim)] = src[RIDX(i+, j+, dim)];
				   dst[RIDX(dim-1-j+, i+, dim)] = src[RIDX(i+, j+, dim)];		
				

*/
/*********************************************************************
 * register_rotate_functions - Register all of your different versions
 *     of the rotate kernel with the driver by calling the
 *     add_rotate_function() for each test function. When you run the
 *     driver program, it will test and report the performance of each
 *     registered test function.  
 *********************************************************************/

void register_rotate_functions() 
{
    add_rotate_function(&naive_rotate, naive_rotate_descr);   
    add_rotate_function(&rotate, rotate_descr);   
    /* ... Register additional test functions here */
}


/***************
 * SMOOTH KERNEL
 **************/

/***************************************************************
 * Various typedefs and helper functions for the smooth function
 * You may modify these any way you like.
 **************************************************************/

/* A struct used to compute averaged pixel value */
typedef struct {
    int red;
    int green;
    int blue;
    int num;
} pixel_sum;

/* Compute min and max of two integers, respectively */
static int min(int a, int b) { return (a < b ? a : b); }
static int max(int a, int b) { return (a > b ? a : b); }

/* 
 * initialize_pixel_sum - Initializes all fields of sum to 0 
 */
static void initialize_pixel_sum(pixel_sum *sum) 
{
    sum->red = sum->green = sum->blue = 0;
    sum->num = 0;
    return;
}

/* 
 * accumulate_sum - Accumulates field values of p in corresponding 
 * fields of sum 
 */
static void accumulate_sum(pixel_sum *sum, pixel p) 
{
    sum->red += (int) p.red;
    sum->green += (int) p.green;
    sum->blue += (int) p.blue;
    sum->num++;
    return;
}

/* 
 * assign_sum_to_pixel - Computes averaged pixel value in current_pixel 
 */
static void assign_sum_to_pixel(pixel *current_pixel, pixel_sum sum) 
{
    current_pixel->red = (unsigned short) (sum.red/sum.num);
    current_pixel->green = (unsigned short) (sum.green/sum.num);
    current_pixel->blue = (unsigned short) (sum.blue/sum.num);
    return;
}

/* 
 * avg - Returns averaged pixel value at (i,j) 
 */
static pixel avg(int dim, int i, int j, pixel *src) 
{
    int ii, jj;
    pixel_sum sum;
    pixel current_pixel;

    initialize_pixel_sum(&sum);
    for(ii = max(i-1, 0); ii <= min(i+1, dim-1); ii++) 
	for(jj = max(j-1, 0); jj <= min(j+1, dim-1); jj++) 
	    accumulate_sum(&sum, src[RIDX(ii, jj, dim)]);

    assign_sum_to_pixel(&current_pixel, sum);
    return current_pixel;
}

/******************************************************
 * Your different versions of the smooth kernel go here
 ******************************************************/

/*
 * naive_smooth - The naive baseline version of smooth 
 */
char naive_smooth_descr[] = "naive_smooth: Naive baseline implementation";
void naive_smooth(int dim, pixel *src, pixel *dst) 
{
    int i, j;

    for (i = 0; i < dim; i++)
	for (j = 0; j < dim; j++)
	    dst[RIDX(i, j, dim)] = avg(dim, i, j, src);
}

/*
 * smooth - Your current working version of smooth. 
 * IMPORTANT: This is the version you will be graded on
 */
char smooth_descr[] = "smooth: Current working version";
void smooth(int dim, pixel *src, pixel *dst) 
{
    naive_smooth(dim, src, dst);
}


/********************************************************************* 
 * register_smooth_functions - Register all of your different versions
 *     of the smooth kernel with the driver by calling the
 *     add_smooth_function() for each test function.  When you run the
 *     driver program, it will test and report the performance of each
 *     registered test function.  
 *********************************************************************/

void register_smooth_functions() {
    add_smooth_function(&smooth, smooth_descr);
    add_smooth_function(&naive_smooth, naive_smooth_descr);
    /* ... Register additional test functions here */
}

