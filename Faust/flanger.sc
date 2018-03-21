FaustFlanger : MultiOutUGen
{
  *ar { | in1, in2, depth(1.0), feedback_gain(0.0), flange_delay_offset(1.0), flange_delay(10.0), invert(0.0), level(0.0), lfobpm(24.0) |
      ^this.multiNew('audio', in1, in2, depth, feedback_gain, flange_delay_offset, flange_delay, invert, level, lfobpm)
  }

  *kr { | in1, in2, depth(1.0), feedback_gain(0.0), flange_delay_offset(1.0), flange_delay(10.0), invert(0.0), level(0.0), lfobpm(24.0) |
      ^this.multiNew('control', in1, in2, depth, feedback_gain, flange_delay_offset, flange_delay, invert, level, lfobpm)
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

  name { ^"FaustFlanger" }


  info { ^"Generated with Faust" }
}

