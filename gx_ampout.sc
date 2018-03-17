FaustAmplifier : UGen
{
  *ar { | in1, amp_out_amp(0.0) |
      ^this.multiNew('audio', in1, amp_out_amp)
  }

  *kr { | in1, amp_out_amp(0.0) |
      ^this.multiNew('control', in1, amp_out_amp)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustAmplifier" }


  info { ^"Generated with Faust" }
}

