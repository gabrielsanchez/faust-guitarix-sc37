FaustDuckDelaySt : MultiOutUGen
{
  *ar { | in1, in2, amount(0.5), attack(0.1), coloration(0.0), effect(0.0), feedback(0.0), pingpong(0.0), release(0.1), time(500.0) |
      ^this.multiNew('audio', in1, in2, amount, attack, coloration, effect, feedback, pingpong, release, time)
  }

  *kr { | in1, in2, amount(0.5), attack(0.1), coloration(0.0), effect(0.0), feedback(0.0), pingpong(0.0), release(0.1), time(500.0) |
      ^this.multiNew('control', in1, in2, amount, attack, coloration, effect, feedback, pingpong, release, time)
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

  name { ^"FaustDuckDelaySt" }


  info { ^"Generated with Faust" }
}

