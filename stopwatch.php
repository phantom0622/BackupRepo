# CodeSkulptor runs Python programs in your browser.
# Click the upper left button to run this simple demo.
# CodeSkulptor runs in Chrome 18+, Firefox 11+, and Safari 6+.
# Some features may work in other browsers, but do not expect
# full functionality.  It does NOT run in Internet Explorer.

import simplegui
miss = 0
get = 0 
message = "Welcome!"
second = 0
tsecond = 0
msecond = 0
minute = 0
tminute = 0

# Handler for mouse click
def clickstart():
    global message
    timer.start()
    message = "Start!"
def clickstop():
    global message,get,miss
    message = "Stop!"
    timer.stop()
    if msecond==0 :
        get=get+1
    else:
        miss=miss+1
    
def clickreset():
    global message,msecond,second,minute
    message = "Reset!"
    timer.stop()
    msecond=0
    second=0
    minute=0

# Handler to draw on canvas
def draw(canvas):
    canvas.draw_text(str(tminute), [50,112], 36, "Red")
    canvas.draw_text(str(minute), [70,112], 36, "Red")
    canvas.draw_text(":", [90,112], 36, "Red")
    canvas.draw_text(str(tsecond), [100,112], 36, "Red")
    canvas.draw_text(str(second), [120,112], 36, "Red")
    canvas.draw_text(".", [135,112], 36, "Red")
    canvas.draw_text(str(msecond), [145,112], 36, "Red")
    canvas.draw_text(message, [20,70], 36, "Red")
    canvas.draw_text(str(get), [250,30], 36, "Green")
    canvas.draw_text("/", [270,30], 36, "Green")
    canvas.draw_text(str(miss), [280,30], 36, "Green")
    
def tick():
    global msecond,minute,second,tsecond,tminute
    msecond=msecond+1
    if msecond%10==0:
        msecond=0
        second=second+1
        if second%10==0:
            second=0
            tsecond=tsecond+1
            if tsecond%6==0:
                tsecond=0
                minute=minute+1
                if minute%10==0:
                    minute=0
                    tminute=tminute+1




# Create a frame and assign callbacks to event handlers
frame = simplegui.create_frame("Home", 300, 200)
frame.add_button("start", clickstart)
frame.add_button("stop", clickstop)
frame.add_button("reset", clickreset)
frame.set_draw_handler(draw)
timer = simplegui.create_timer(100, tick)

# Start the frame animation
frame.start()
