FaustStereoDelay : MultiOutUGen
{
  *ar { | in1, in2, invert(0.0), l_gain(0.0), lbpm(120.0), lfobpm(24.0), r_gain(0.0), rbpm(120.0) |
      ^this.multiNew('audio', in1, in2, invert, l_gain, lbpm, lfobpm, r_gain, rbpm)
  }

  *kr { | in1, in2, invert(0.0), l_gain(0.0), lbpm(120.0), lfobpm(24.0), r_gain(0.0), rbpm(120.0) |
      ^this.multiNew('control', in1, in2, invert, l_gain, lbpm, lfobpm, r_gain, rbpm)
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

  name { ^"FaustStereoDelay" }


  info { ^"Generated with Faust" }
}

