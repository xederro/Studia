#!/usr/bin/env python3
import sys
import random
import time

from glfw.GLFW import *

from OpenGL.GL import *
from OpenGL.GLU import *

now = time.time()

def startup():
    update_viewport(None, 400, 400)
    glClearColor(0.5, 0.5, 0.5, 1.0)


def shutdown():
    pass


def render(time):
    glClear(GL_COLOR_BUFFER_BIT)

    draw_rectangle(-40,0,100,29, 9)
    draw_rectangle(30,-50,34,40)

    glFlush()

def draw_rectangle(x, y, a, b, d=0):
    random.seed(x+y+a+b+d+now)
    glColor3f(random.random(), random.random(), random.random())
    glBegin(GL_TRIANGLES)
    glVertex2f(x-d, y-d)
    glVertex2f(x+a, y)
    glVertex2f(x+d, y+b)
    glEnd()

    glColor3f(random.random(), random.random(), random.random())
    glBegin(GL_TRIANGLES)
    glVertex2f(x+a, y)
    glVertex2f(x+a+d, y+b+d)
    glVertex2f(x+d, y+b)
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


def main():
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
        render(glfwGetTime())
        glfwSwapBuffers(window)
        glfwPollEvents()
    shutdown()

    glfwTerminate()


if __name__ == '__main__':
    main()
