FaustPhaser : MultiOutUGen
{
  *ar { | in1, in2, maxnotch1freq(800.0), minnotch1freq(100.0), notch_width(1000.0), notchfreq(1.5), vibratomode(0.0), depth(1.0), feedback_gain(0.0), invert(0.0), level(0.0), lfobpm(30.0) |
      ^this.multiNew('audio', in1, in2, maxnotch1freq, minnotch1freq, notch_width, notchfreq, vibratomode, depth, feedback_gain, invert, level, lfobpm)
  }

  *kr { | in1, in2, maxnotch1freq(800.0), minnotch1freq(100.0), notch_width(1000.0), notchfreq(1.5), vibratomode(0.0), depth(1.0), feedback_gain(0.0), invert(0.0), level(0.0), lfobpm(30.0) |
      ^this.multiNew('control', in1, in2, maxnotch1freq, minnotch1freq, notch_width, notchfreq, vibratomode, depth, feedback_gain, invert, level, lfobpm)
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

  name { ^"FaustPhaser" }


  info { ^"Generated with Faust" }
}

