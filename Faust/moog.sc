FaustMoogFilter : MultiOutUGen
{
  *ar { | in1, in2, q(1.0), fr(3000.0) |
      ^this.multiNew('audio', in1, in2, q, fr)
  }

  *kr { | in1, in2, q(1.0), fr(3000.0) |
      ^this.multiNew('control', in1, in2, q, fr)
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

  name { ^"FaustMoogFilter" }


  info { ^"Generated with Faust" }
}

