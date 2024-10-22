#!/usr/bin/env python3
import argparse
import sys
import random
from time import sleep

from glfw.GLFW import *

from OpenGL.GL import *
from OpenGL.GLU import *


def startup():
    update_viewport(None, 400, 400)
    glClearColor(0.5, 0.5, 0.5, 1.0)


def shutdown():
    pass


def render(time, step):
    glClear(GL_COLOR_BUFFER_BIT)
    sX = -75
    sY = -75
    sA = 150
    sB = 100

    glColor3f(0.0, 0.0, 0.0)
    draw_rectangle(sX,sY,sA,sB)
    glColor3f(1.0, 1.0, 1.0)

    for i in range(step):
        n = 3**(i+1)
        for j in range(3**i):
            m = 1+3*j
            for k in range(3**i):
                draw_rectangle(sX+sA*m/n, sY+sB*(1+3*k)/n, sA/n, sB/n)


    glFlush()

def draw_rectangle(x, y, a, b, d=0):
    glBegin(GL_TRIANGLES)
    glVertex2f(x-d, y-d)
    glVertex2f(x+a, y)
    glVertex2f(x, y+b)
    glEnd()

    glBegin(GL_TRIANGLES)
    glVertex2f(x+a, y)
    glVertex2f(x+a+d, y+b+d)
    glVertex2f(x, y+b)
    glEnd()



def update_viewport(window, width, height):
    if width == 0:
        width = 1
    if height == 0:
        height = 1
    aspect_ratio = width / height

    glMatrixMode(GL_PROJECTION)
    glViewport(0, 0, width, height)
    glLoadIdentity()

    if width <= height:
        glOrtho(-100.0, 100.0, -100.0 / aspect_ratio, 100.0 / aspect_ratio,
                1.0, -1.0)
    else:
        glOrtho(-100.0 * aspect_ratio, 100.0 * aspect_ratio, -100.0, 100.0,
                1.0, -1.0)

    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()


def main(step):
    if not glfwInit():
        sys.exit(-1)

    window = glfwCreateWindow(400, 400, __file__, None, None)
    if not window:
        glfwTerminate()
        sys.exit(-1)

    glfwMakeContextCurrent(window)
    glfwSetFramebufferSizeCallback(window, update_viewport)
    glfwSwapInterval(1)

    startup()
    while not glfwWindowShouldClose(window):
        render(glfwGetTime(), step)
        glfwSwapBuffers(window)
        glfwPollEvents()
    shutdown()

    glfwTerminate()


if __name__ == '__main__':
    parser = argparse.ArgumentParser(prog='zad4')
    parser.add_argument('step')
    args = parser.parse_args()
    main(int(args.step))
