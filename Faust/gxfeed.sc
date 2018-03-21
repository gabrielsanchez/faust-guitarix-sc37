FaustGxfeed : MultiOutUGen
{
  *ar { | in1, in2, amp_feed_on_off(0.0), amp_wet_dry(0.0) |
      ^this.multiNew('audio', in1, in2, amp_feed_on_off, amp_wet_dry)
  }

  *kr { | in1, in2, amp_feed_on_off(0.0), amp_wet_dry(0.0) |
      ^this.multiNew('control', in1, in2, amp_feed_on_off, amp_wet_dry)
  } 

  checkInputs {
    if (rate == 'audio', {
      2.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(2, rate)
  }

  name { ^"FaustGxfeed" }


  info { ^"Generated with Faust" }
}

