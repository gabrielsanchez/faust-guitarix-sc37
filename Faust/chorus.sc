FaustChorus : MultiOutUGen
{
  *ar { | in1, in2, delay(0.02), depth(0.02), freq(3.0), level(0.5) |
      ^this.multiNew('audio', in1, in2, delay, depth, freq, level)
  }

  *kr { | in1, in2, delay(0.02), depth(0.02), freq(3.0), level(0.5) |
      ^this.multiNew('control', in1, in2, delay, depth, freq, level)
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

  name { ^"FaustChorus" }


  info { ^"Generated with Faust" }
}

