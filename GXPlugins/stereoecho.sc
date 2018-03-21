FaustStereoEcho : MultiOutUGen
{
  *ar { | in1, in2, invert(0.0), lbpm(120.0), lfobpm(24.0), percent_l(0.0), percent_r(0.0), rbpm(120.0) |
      ^this.multiNew('audio', in1, in2, invert, lbpm, lfobpm, percent_l, percent_r, rbpm)
  }

  *kr { | in1, in2, invert(0.0), lbpm(120.0), lfobpm(24.0), percent_l(0.0), percent_r(0.0), rbpm(120.0) |
      ^this.multiNew('control', in1, in2, invert, lbpm, lfobpm, percent_l, percent_r, rbpm)
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

  name { ^"FaustStereoEcho" }


  info { ^"Generated with Faust" }
}

