#!/usr/bin/env python3
import argparse
import sys
import random
from time import sleep

from glfw.GLFW import *

from OpenGL.GL import *
from OpenGL.GLU import *


def startup():
    update_viewport(None, 800, 600)
    glClearColor(0.5, 0.5, 0.5, 1.0)


def shutdown():
    pass


def render(time, mandelbrot):
    glClear(GL_COLOR_BUFFER_BIT)

    glColor3f(1.0, 0.0, 0.0)
    glBegin(GL_POINTS)
    for i in mandelbrot:
        glVertex2i(i['x'], i['y'])
    glEnd()

    glFlush()



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
        glOrtho(-300.0, 300.0, -300.0 / aspect_ratio, 300.0 / aspect_ratio,
                1.0, -1.0)
    else:
        glOrtho(-300.0 * aspect_ratio, 300.0 * aspect_ratio, -300.0, 300.0,
                1.0, -1.0)

    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()


def calc_mandelbrot():
    points=[]
    for i in range(-400, 300):
        for j in range(-400, 300):
            z = complex(0,0)
            p = complex(i/200, j/200)
            for k in range(100):
                z = z*z + p
            if abs(z) < 300:
                points.append({'x': i+50, 'y': j})
    return points




def main():
    if not glfwInit():
        sys.exit(-1)

    window = glfwCreateWindow(800, 600, __file__, None, None)
    if not window:
        glfwTerminate()
        sys.exit(-1)

    glfwMakeContextCurrent(window)
    glfwSetFramebufferSizeCallback(window, update_viewport)
    glfwSwapInterval(1)

    startup()
    while not glfwWindowShouldClose(window):
        render(glfwGetTime(), calc_mandelbrot())
        glfwSwapBuffers(window)
        glfwPollEvents()
    shutdown()

    glfwTerminate()

if __name__ == '__main__':
    main()
