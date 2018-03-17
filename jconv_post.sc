FaustJconvPost : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, amp_balance(0.0), balance(0.0), diff_delay(0.0), gain(0.0), wet_dry(100.0) |
      ^this.multiNew('audio', in1, in2, in3, in4, amp_balance, balance, diff_delay, gain, wet_dry)
  }

  *kr { | in1, in2, in3, in4, amp_balance(0.0), balance(0.0), diff_delay(0.0), gain(0.0), wet_dry(100.0) |
      ^this.multiNew('control', in1, in2, in3, in4, amp_balance, balance, diff_delay, gain, wet_dry)
  } 

  checkInputs {
    if (rate == 'audio', {
      4.do({|i|
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

  name { ^"FaustJconvPost" }


  info { ^"Generated with Faust" }
}

